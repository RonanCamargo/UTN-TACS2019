import React, { Component } from "react";

class LoginUser extends Component {
    constructor() {
        super();
        this.state = { data: [] };
    }

    componentDidMount() {
        fetch(`http://localhost:8080/users`)
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