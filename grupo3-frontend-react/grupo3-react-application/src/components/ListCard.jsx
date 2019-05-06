import React, {Component} from 'react';
import InputGroup from './InputGroup';
import EditButton from './EditButton';

class ListCard extends Component
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

					    <div className = "card-header" className="listCardHeader">
                  <a target="_blank" href={ this.props.url } >
                    <img  src={ this.props.url } className="thumb" alt="Cinque Terre" width="300" height="auto">
                    </img>
                  </a>
					    </div>

					    <div className = "card-body">
                <div className = "row-md-2">
                  <p>{ this.props.cardName } </p>
                    {!this.state.isHidden && <EditButton />}
                </div>
					    </div>
          </div>
        </div>
  		);
  }
}

export default ListCard;
