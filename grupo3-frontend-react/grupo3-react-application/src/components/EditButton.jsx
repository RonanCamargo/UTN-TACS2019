import React, {Component} from 'react';
import EditForm from './EditForm';

class EditButton extends Component
{
  constructor(props) {
    super(props);
    this.state = {isToggleOn: false};
    this.handleClick = this.handleClick.bind(this);
  }

  handleClick() {
    this.setState(state => ({
      isToggleOn: !state.isToggleOn
    }));
  }

  render()
  {
    return(
        <div className="input-group">

            <button type="submit" className="btn btn-outline-secondary" onClick={this.handleClick}>
                  <i className="fa fa-edit"></i>

            </button>

        </div>
  		);
  }
}

export default EditButton;
