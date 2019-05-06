import React, { Component } from 'react'
import {
    Route,
    Redirect,
    Switch,
    withRouter
} from 'react-router-dom'
import LogInUser from 'views/login/user/login_user'
import PlaceView from 'views/place/PlaceView'
import ListView from 'views/place/ListView'
import AdminView from 'views/admin/AdminView'

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
                    <Route path={'/places'} component={PlaceView} />
                    <Route path={'/users/list-of-places'} component={ListView} />
                    <Route path={'/users'} component={AdminView} />
                </Switch>
            </div>
        )
    }
}

export default withRouter(App)
