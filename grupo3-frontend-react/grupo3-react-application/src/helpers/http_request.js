import superagentPromisePlugin from 'superagent-promise-plugin'
import generic_request_error from './generic_request_error'
import http_agent from './http_agent'

function put(url) {
    return new Request('put', url)
}

function post(url) {
    return new Request('post', url)
}

function get(url) {
    return new Request('get', url)
}

function del(url) {
    return new Request('del', url)
}

function _type(value) {
    this._type = value
    return this
}

function _withCredentials(value) {
    this._needsCredentials = !!value
    return this
}

function _withHeaders(values) {
    if(values) {
        for(var s in values) {
            this.headers[s] = values[s]
        }
    }
    return this
}

function _addCredentials(request) {
    if(this._needsCredentials) {
        return request.withCredentials()
    }
    return request
}

function _addType(request) {
    if(this._type) {
        return request.type(this._type)
    }
    return request
}

function _addHeaders(request) {
    for(var s in this.headers) {
        request.set(s, this.headers[s])
    }
    return request
}

function _send(data = {}) {
    let promise = new Promise((resolveFunction, rejectFunction) => {
        this.iterateRequest(data, this._method === 'get' ? 'query' : 'send').then((response)=>resolveFunction(response))
            .catch(err => {
                generic_request_error(err)
                rejectFunction(err)
            })
    })
    return promise
}

function _iterateRequest(data, mode) {
    let resolveFunction, rejectFunction
    let promise = new Promise((res, rej) => {
        resolveFunction = res
        rejectFunction = rej
    })
    let retry = () => {
        let request = mode === 'query' ? this.queryRequest(data) : this.sendRequest(data)
        request.then(function(response) {
            resolveFunction(response)
        }).catch(err => {
            this._currentAttempt += 1
            if(this._currentAttempt < this.maximumAttemps) {
                setTimeout(retry, this._retryDelay)
            } else {
                if(!err || !err.response) {
                    rejectFunction({error_code: -1})
                } else {
                    if(err.response.body) {
                        rejectFunction(err.response.body)
                    } else if(err.response.text) {
                        try {
                            rejectFunction(JSON.parse(err.response.text))
                        } catch(error) {
                            rejectFunction("")
                        }
                    } else {
                        rejectFunction("")
                    }
                }
            }
        })
    }
    retry()

    return promise
}

function _sendRequest(data) {
    let _request = this.callMethod(this._url)
        .send(data)
    this.addType(_request)
    this.addHeaders(_request)
    return this.addCredentials(_request)
        .use(superagentPromisePlugin)
        .then(function(response) {
            let payload = JSON.parse(response.text)
            return payload
        })
}

function _queryRequest(data) {
    let _request = this.callMethod(this._url)
        .query(data)
        .type(this._type)
    this.addHeaders(_request)
    return this.addCredentials(_request)
        .use(superagentPromisePlugin)
        .then(function(response) {
            let payload = JSON.parse(response.text)
            return payload
        })
}

function callMethod(url) {
    switch(this._method) {
        case 'put':
            return http_agent.put(url)
        case 'post':
            return http_agent.post(url)
        case 'get':
            return http_agent.get(url)
        case 'del':
            return http_agent.del(url)
    }
}

function Request(method, url){
    this._method = method
    this._url = url
    this._data = null
    this._type = 'json'
    this.headers = {}
    this._needsCredentials = true
    this._currentAttempt = 0
    this.maximumAttemps = 1
    this._retryDelay = 5000
    this.send = _send
    this.withCredentials = _withCredentials
    this.withHeaders = _withHeaders
    this.addCredentials = _addCredentials
    this.addType = _addType
    this.addHeaders = _addHeaders
    this.sendRequest = _sendRequest
    this.queryRequest = _queryRequest
    this.iterateRequest = _iterateRequest
    this.type = _type
    this.callMethod = callMethod
}

export default {
    put,
    post,
    get,
    delete: del,
}
