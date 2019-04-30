import React, { Component } from "react";
import http_request from 'helpers/http_request'

class LoginUser extends Component {
    constructor() {
        super();
        this.state = { data: [] };
    }

    componentDidMount() {
        http_request.get('http://localhost:8080/users')
        .send()
        .then(res => res.json())
        .then(json => this.setState({ data: json }));
    }

    render() {
        return (
            <div>
                <ul>
                    {this.state.data.map(user => (
                        <li>
                            {user.name}: {user.lastName}
                        </li>
                    ))}
                </ul>
            </div>
        );
    }
}

export default LoginUser;