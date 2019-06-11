import React, {Component} from 'react'

class Navigation extends Component {
	render() {
		return(
			<nav className = "navbar navbar-dark bg-dark">
				<a href="" className ="text-white">  { this.props.title} </a>
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
