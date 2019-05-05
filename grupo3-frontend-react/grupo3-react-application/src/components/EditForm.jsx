import React, {Component} from 'react';

class EditForm extends Component
{
  constructor(props) {
    super(props);
    this.state = {name: 'list'};

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({value: event.target.value});
  }

  handleSubmit(event) {
    alert('A name was submitted: ' + this.state.name);
    event.preventDefault();
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <h3>  Edit your list:  </h3>
        <label>
        Name:
          <input type="text" value={this.state.name} onChange={this.handleChange} />
        </label>
        <span className="input-group-btn">
        <button type="submit" className="btn btn-outline-secondary">Delete</button>
        </span>
        <span className="input-group-btn">
        <button type="submit" className="btn btn-outline-secondary">Cancel</button>
        </span>
        <span className="input-group-btn">
        <button type="submit" className="btn btn-danger">Save</button>
        </span>
      </form>
    );
  }
}

export default EditForm;
