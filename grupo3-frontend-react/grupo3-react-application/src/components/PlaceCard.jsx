import React, {Component} from 'react';
import InputGroup from './InputGroup';

class PlaceCard extends Component
{
	constructor () {
	    super()
	    this.state = {
	      isHidden: true
	    }
	  }

	  toggleHidden () {
	    this.setState({
	      isHidden: !this.state.isHidden
	    })
	  }

  render()
  {
    return(
        <div className = "col-md-4" >
          <div className = "card mt-4"
						  onMouseEnter={this.toggleHidden.bind(this)}
							onMouseLeave={this.toggleHidden.bind(this)}>

					    <div className = "card-header">
					        <h3>{ this.props.cardName }</h3>
					        <span className= "badge badge-pill badge-danger ml-2">Flag</span>
					        <span className="badge badge-pill badge-warning">Star</span>
					        <i className="fa fa-star"></i>
					    </div>

					    <div className = "card-body">
								{!this.state.isHidden && <InputGroup label="Save" />}
							  <a target="_blank" href={ this.props.url } >
							    <img src={ this.props.url } alt="Cinque Terre" width="100%" height="auto" className={ this.props.image }>
									</img>
							  </a>
					        <p><mark>some description</mark></p>
					        <p>id: { this.props.id }</p>

					    </div>
          </div>
        </div>
  		);
  }
}

export default PlaceCard;
