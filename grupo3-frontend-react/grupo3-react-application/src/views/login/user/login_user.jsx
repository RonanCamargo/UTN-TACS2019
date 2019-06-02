import React, { Component } from "react"
import { Form, Button, FormGroup, FormControl, Alert } from "react-bootstrap"
import CSSModules from "react-css-modules"
import axios from "axios"
import styles from "./login_user.css"

class LoginUser extends Component {
	constructor(props){
		super(props)
		this.state = {
			userName : '',
			password : '',
		}
	}
	
	// validateForm() {
	// 	return this.state.name.length > 0 && this.state.password.length > 0
	// }

	handleChange = event => {
		this.setState({
			[event.target.id]: event.target.value
		})
	}

	handleSubmit = event => {
		event.preventDefault()
		const user = {
			username: this.state.userName,
			password: this.state.password
		}
		try {
			axios.post("http://localhost:8080/login", user)
			.then(res => {
				this.props.history.push("/places")
				this.props.updateProps('userLogged',1)
				this.props.updateProps('userName',this.state.userName)
			})
		} catch (error) {
			console.log(error)
		}
	}

	render() {
		return (
			<div className="Login">
				<Form onSubmit={this.handleSubmit}>
					<Form.Group controlId="userName">
						<Form.Label>Username/Email</Form.Label>
						<Form.Control
							autoFocus
							type="text"
							value={this.state.userName}
							onChange={this.handleChange}
							placeholder="Enter username or email"
						/>
					</Form.Group>

					<Form.Group controlId="password">
						<Form.Label>Password</Form.Label>
						<Form.Control
							value={this.state.password}
							onChange={this.handleChange}
							type="password"
							placeholder="Password"
						/>
					</Form.Group>
					<Form.Group controlId="signup">
						<Form.Label>
							{"Don't have an account? "}
							<Alert.Link href="http://localhost:8008/signup">
								Sign Up
							</Alert.Link>
						</Form.Label>
					</Form.Group>
					<Button
						block
//						disabled={!this.validateForm()}
						type="submit"
						variant="primary"
					>
						Login
					</Button>
				</Form>
			</div>
		)
	}
}
export default CSSModules(LoginUser, styles, { allowMultiple: true })
