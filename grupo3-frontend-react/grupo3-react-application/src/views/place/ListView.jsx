import React, { Component } from "react"
import Navigation from 'components/Navigation'
import axios from 'axios'
import ListCard from 'components/ListCard'

class ListView extends Component {
	constructor() {
		super()
		this.state = {
			lists: [
				{ "id": "1",
					"listName": "FAVS",
					"icon": "https://i.pinimg.com/564x/cc/37/00/cc3700036af63f1da9e2cff08b5d37b6.jpg",
					"places":  [
						{
							"id": "57",
							"name": "Union Fare",
							"location": "https://i.pinimg.com/564x/cc/37/00/cc3700036af63f1da9e2cff08b5d37b6.jpg",
						},
						{
							"id": "58",
							"name": "Trending Fare",
							"location": "https://i.pinimg.com/564x/24/35/c3/2435c38be64f613306d5c055d8843369.jpg",
						},
						{
							"id": "54",
							"name": "Barn kitse",
							"location": "https://i.pinimg.com/564x/b6/db/b0/b6dbb0f93cc22a3fc4b014d61eb3be7f.jpg",
						}
					]
				},
				{ "id": "2",
					"listName": "FOOD NATION",
					"icon": "https://i.pinimg.com/564x/45/a5/ed/45a5ed73ccda4329e31c26091dfd8d01.jpg",
					"places":  [
						{
							"id": "66",
							"name": "Union Fare",
							"location": "https://i.pinimg.com/564x/45/a5/ed/45a5ed73ccda4329e31c26091dfd8d01.jpg",
						},
						{
							"id": "67",
							"name": "Pancho ville",
							"location": "https://i.pinimg.com/564x/3a/00/4a/3a004aa0370714764f5e0e92b985a5a2.jpg",
						},
						{
							"id": "68",
							"name": "Pizza party",
							"location": "https://i.pinimg.com/564x/29/b0/9f/29b09f560cd7c94c7820e5e0c94477ad.jpg",
						}
					]
				},
				{ "id": "3",
					"listName": "MUSIC PLACES",
					"icon": "https://i.pinimg.com/564x/e6/1d/50/e61d50d44e225cebec03c73144c1be21.jpg",
					"places":  [
						{
							"id": "77",
							"name": "Union PACIFIC",
							"location": "https://i.pinimg.com/564x/e6/1d/50/e61d50d44e225cebec03c73144c1be21.jpg",
						},

					]
				}
			]

		}
	}

	componentDidMount() {
		const user_id = "Juan"
		axios.get(`http://localhost:8080//users/${user_id}/list-of-places`,{withCredentials:true})
		.then(json => this.setState({ lists: json }))
	}

	render() {
		const lists = this.state.lists.map((list,i) => {
			return(
				<ListCard key={i} cardName = {list.listName} id = {list.id} url = {list.icon} />
			)
		})

		return (
			<div className="main-container">
				<Navigation title= "Home"/>
				<div className= "helper">
					<div className= "row mt-4">
						<p><strong>Borrar todo esto.</strong></p>
						<p>View para users.</p>
						<p>Agregar form con botones para permitir editar el nombre de la lista o para eliminarla.</p>
						<p>Ver si conviene tambien crear listas desde aca</p>
						<p>Al hacer click en un card de list mostrar su contenido de places</p>
					</div>
				</div>
				<div className= "container md-2">
					<h3>my lists</h3>
					<div className= "container">
						<div className= "row">
							<div className="row active-with-click">
								{lists}
							</div>
						</div>
					</div>
				</div>

			</div>
		)
	}
}

export default ListView
