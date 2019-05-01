import React, { Component } from 'react'
import {
    Route,
    Redirect,
    Switch,
    withRouter
} from 'react-router-dom'
import LogInUser from 'views/login/user/login_user'

class App extends Component {

    constructor(props) {
        super(props)
        window.dataLayer = window.dataLayer || []
    }

    render() {
        return (
            <div>
                <Switch>
                    <Route path={'/login'} component={LogInUser} />
                </Switch>
            </div>
        )
    }
}

export default withRouter(App)
