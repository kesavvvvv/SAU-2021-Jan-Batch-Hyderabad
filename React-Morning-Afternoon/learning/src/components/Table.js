import React from 'react';
import PropTypes from 'prop-types';

class Table extends React.Component {
    render() {
        console.log(this.props.apicall);
        return (
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Login</th>
                        <th>URL</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                
                    {this.props.apicall.map((apicall) => (
                        <tr>
                            <td>{apicall.id}  </td>
                            <td>{apicall.login}  </td>
                            <td>{apicall.url}  </td>
                            <button onClick = {this.props.delRow.bind(this, apicall.id)} style = {btnStyle}  >X</button>
                        </tr>        
                    ))}
                </tbody>   
            </table>    
        );
    }
}

const btnStyle = {
    background: '#ff0000',
    color: '#fff',
    border: 'none',
    borderRadius: '50%',
    cursor: 'pointer'

}

Table.propTypes = {
    tables: PropTypes.array.isRequired
}

export default Table;