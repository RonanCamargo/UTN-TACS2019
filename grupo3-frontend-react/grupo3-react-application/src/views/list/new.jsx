import React, { Component } from "react"
import { Form, Button, FormGroup, FormControl, Alert } from "react-bootstrap"
import CSSModules from "react-css-modules"
import axios from "axios"
import Search from "components/search"
import Place from "components/place"

import styles from "./new.css"

class ListNew extends Component {
	constructor(props){
		super(props)
		this.state = {
			listName: '',
			canAddPlacesToList : true,
			places: [],
		}
	}

	handleChange = event => {
		this.setState({
			[event.target.id] : event.target.value
		})
	}

	handleSubmit = async event => {
		event.preventDefault()
		try {
			axios.post('http://localhost:8080/users/'+ this.props.userName +'/list-of-places/'+ this.state.listName)
			.then(res => {
				alert(res.text)
				this.setState({
					canAddPlacesToList : true
				})
			})
		} catch (error) {
			alert(error)
		}
	}

	searchNearPlaces(){
		const location = this.props.coords.latitude + ',' + this.props.coords.longitude
		const token = localStorage.getItem("token")
		try {
			axios.get('http://localhost:8080/places/near?coordinates=' + location, {
				headers: {
					Authorization: 'Bearer ' + token
				}
			})
			.then(response => {
				this.setState({places : response.data})
			})
		} catch (e) {
			console.log(e)
		}
	}

	componentDidUpdate(prevProps) {
		if (this.props.coords && !prevProps.coords) {
			this.initDashboard()
		}
	}

	render() {
		const places = this.state.places.map(place => {
			return(
				<Place title={place.name} subTitle={place.location.address} description={"Some Desc"}/>
			)
		})
		return (
			<div>
				{!this.state.canAddPlacesToList ? (
				<Form onSubmit={this.handleSubmit}>
					<h2>Select List Name</h2>
					<Form.Group controlId="listName">
						<Form.Control
							autoFocus
							value={this.state.listName}
							onChange={this.handleChange}
							placeholder="Put List name"
						/>
					</Form.Group>
					<Button	type="submit" variant="primary">Create List</Button>
				</Form>) : (
					<div>
						<h3>Search Places</h3>
						<Search/>
						<ButtonToolbar>
							<Button variant="primary" onClick={() => this.searchNearPlaces}>Near</Button>
							<Button variant="primary">Other Filter</Button>
						</ButtonToolbar>
						<div className="places-container">
							{places}
						</div>
					</div>
				)}
			</div>
		)
	}
}

export default CSSModules(ListNew, styles, { allowMultiple: true })
