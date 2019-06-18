import React, {Component} from 'react'
import {Button} from "react-bootstrap"

class Navigation extends Component {
	render() {
		return(
			<nav className = "navbar navbar-dark bg-dark">
				<Button variant="dark" onClick={() => this.props.history.push('/home')}>{this.props.title}</Button>
					<div className = "row-md-2">
					<div className="input-group">
						<input type="text" className="form-control" placeholder="Search"></input >
						<span className="input-group-btn">
							<button type="submit" className="btn btn-outline-secondary"><i className="fa fa-search"></i></button>
						</span>
					</div>
				</div>
			</nav>
		)
	}
}

export default Navigation
