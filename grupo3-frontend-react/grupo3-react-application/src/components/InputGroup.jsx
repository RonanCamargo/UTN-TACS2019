import React, {Component} from 'react'
import Popup from 'reactjs-popup'
import axios from "axios";

class InputGroup extends Component {
	constructor(props) {
		super(props)
		this.state = {
			isVisited : false,
		}
		this.markAsVisited = this.markAsVisited.bind(this)
	}

	markAsVisited() {
		try {
			const token = localStorage.getItem("token")
			if(!this.props.userName) {
				axios.get(API +'/me', {
					headers: {
						Authorization: 'Bearer ' + token
					}
				})
				.then(response => {
					alert(response.data.message)

					//poner la response como props y obtener el id
				})
				.catch(error => {
					alert(error.response.data.message)
				})
			}

			axios.put(API +'/users/' + this.props.userName +'/places-visited/'+ this.props.placeId +'?',
				{},{
				headers: {
					Authorization: 'Bearer ' + token
				}
			})
			.then(response => {
				alert(response.data.message)
				this.setState({isVisited: true })
			})
			.catch(error => {
				alert(error.response.data.message)
			})
		} catch (e) {
			console.log(e)
		}
	}
	render() {
		let isVisited = this.props.isVisited ? 'Visited' : 'Unvisited'
		return(
			<div className = "card mb-2">
                <Popup trigger={!this.state.isVisited && <div className = "row-md-4">
	                <div className="input-group">
                        <select className="form-control" id="selectList" placeholder= "select a List">
							<option>{isVisited}</option>
							<option>Visited</option>
                        </select>
                         <span className="input-group-btn">
                            <button type="submit" className="btn btn-danger" onClick={this.markAsVisited} >{ this.props.label }</button>
                        </span>
                    </div>
                    </div>}
  				position="right top"
  				on="hover"
  				>
                </Popup>
          </div>
		)
	}
}

export default InputGroup
