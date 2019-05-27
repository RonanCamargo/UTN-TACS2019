import React, { Component } from "react"
import Navigation from 'components/Navigation'
import PlaceCard from 'components/PlaceCard'
import { geolocated } from 'react-geolocated'
import axios from 'axios'

class PlaceView extends Component {
	constructor() {
		super()
		this.state = {
			places: [
				{ "id": "1",
					"name": "Washington Square Park",
					"location": "https://i.pinimg.com/564x/d7/be/ea/d7beea08f312788090240120bd929b01.jpg"
				}
				,
				{ "id": "2",
					"name": "South Park",
					"location": "https://i.pinimg.com/564x/7a/6b/e3/7a6be38270ff81198292148236222748.jpg"
				}
				,
				{ "id": "3",
					"name": "Washington DC",
					"location": "https://i.pinimg.com/564x/55/9e/43/559e43ef4ff55bf74be9c21e35191234.jpg"
				},
				{ "id": "4",
					"name": "La Noria",
					"location": "https://i.pinimg.com/564x/ed/59/7e/ed597ee6b1bba5a37a4ec337b26ce737.jpg"
				}
				,
				{ "id": "5",
					"name": "Mexico",
					"location": "https://i.pinimg.com/564x/13/42/36/134236aa9b5b7a6e5e400d8f5fbb34e4.jpg"
				}
				,
				{ "id": "6",
					"name": "China",
					"location": "https://i.pinimg.com/564x/f1/1e/82/f11e82851e2390f633d2ceb15a51b021.jpg"
				}
			]
		}
	}

    componentDidMount() {
		console.log(this.props)
		console.log(this.props.coords)
		if(this.props.coords) {
			console.log("entre")
			const data = {
				coordinates : this.props.coords.latitude + ',' + this.props.coords.longitude
			}
			axios.get('http://localhost:8080/places/near', {
				headers: {
					Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJlc3RlYmFuIn0.yPI_FTYssUxfEFJvfcS9X1NQR3A4e23jHf3-HFM2mLEWRWun3l3j30Omz0sv8eGlYiCLb3pXBQlUi2XhmKD2Iw'
				},
				data
			})
		    .then(json =>
			    console.log(json)
		     )
		}
    }

	render() {
		const places = this.state.places.map(place => {
			return(
				<PlaceCard key={place.id} cardName = {place.name} id = {place.id} url = {place.location} image = "w3-grayscale-max" />
			)
		})
		return (
			<div className="main-container">
				<Navigation title= "Home" />
				<div className= "helper">
					<div className= "row mt-4">
						<p><strong>Borrar todo esto.</strong></p>
						<p>View para users o admins.</p>
						<p>Un user podra buscar places con search.</p>
						<p>Search desplegara un form de criterios de busqueda.</p>
						<p>Un user podra agregar un lugar a una de sus listas con "save".</p>
						<p>Un user podra crear una lista nueva con "create" agregando un nombre de lista.</p>
						<p>Un user podra marcar un lugar con un flag de visitado.</p>
						<p>Un admin podra ver un star con el numero de users que tienen guardado un lugar en alguna de sus listas.</p>
					</div>
				</div>
				<div className= "container">
					<div className= "row mt-4">
						<div className="row active-with-click">
							{places}
						</div>
					</div>
				</div>
			</div>
		)
	}
}

export default geolocated({
	positionOptions: {
		enableHighAccuracy: false,
	},
	userDecisionTimeout: 5000,
})(PlaceView)
