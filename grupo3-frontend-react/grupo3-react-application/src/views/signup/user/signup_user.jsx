import React, { Component } from 'react'
import { Form, Button, FormGroup, FormControl, Alert } from "react-bootstrap"
import CSSModules from 'react-css-modules'
import axios from 'axios';
import styles from "./signup_user.css"

class SignUp extends Component {

    constructor() {
        super()
        this.state = {
            firstName : "",
            lastName : "",
            email : "",
            password : ""
        }
    }

    validateForm() {
        return (this.state.email.length > 0 && this.state.password.length > 0)
    }

    handleChange = event => {
        this.setState({
            [event.target.id]: event.target.value
        })
    }

    handleSubmit = async event => {
        event.preventDefault()
        try{
            const response = await axios.post(
                'http://localhost:8080/security/register',
                {
                    firstName: this.state.firstName,
                    lastName: this.state.lastName,
                    username: this.state.email,
                    password: this.state.password
                }
            );

            alert(response.data);
        }
        catch(error) {
            alert(error);
        }
    }

    render() {
        return (
            <div className="signup">
                <Form onSubmit={this.handleSubmit}>
                    <h2>Sign up</h2>
                    <Form.Group controlId="firstName">
                        <Form.Control
                            autoFocus
                            value={this.state.firstName}
                            onChange={this.handleChange}
                            placeholder="First name"
                        />
                    </Form.Group>
                    <Form.Group controlId="lastName">
                        <Form.Control
                            autoFocus
                            value={this.state.lastName}
                            onChange={this.handleChange}
                            placeholder="Last name"
                        />
                    </Form.Group>
                    <Form.Group controlId="email">
                        <Form.Control
                            autoFocus
                            type="email"
                            value={this.state.email}
                            onChange={this.handleChange}
                            placeholder="Email"
                        />
                    </Form.Group>

                    <Form.Group controlId="password">
                        <Form.Control
                            value={this.state.password}
                            onChange={this.handleChange}
                            type="password"
                            placeholder="Password"
                        />
                    </Form.Group>
                    <Button
                        disabled={!this.validateForm()}
                        type="submit"
                        variant="primary">
                        Sign Up
                    </Button>
                </Form>
            </div>
        )
    }
}

export default CSSModules(SignUp, styles, {allowMultiple: true})