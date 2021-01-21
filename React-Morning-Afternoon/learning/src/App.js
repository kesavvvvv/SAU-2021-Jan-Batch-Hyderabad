import './App.css';
import React from 'react';
import Table from './components/Table'

class App extends React.Component {
    state = {
        droplets: [],
        tables: [
            {

                id: 1,
                name: 'kesav',
                dept: 'ece',
                pass: 'false'
            },
            {

                id: 2,
                name: 'raj',
                dept: 'ece',
                pass: 'false'
            },
            {

                id: 3,
                name: 'anam',
                dept: 'ece',
                pass: 'false'
            }
        ]
    }

    componentDidMount(){
        fetch("https://api.github.com/users/hadley/orgs")
          .then((res) => res.json())
          .then((res) => this.setState({'droplets': res}));
    }

    markPass = (id) => {
        console.log(id)
    }

    delRow = (id) => {
        this.setState({ droplets: [...this.state.droplets.filter(droplets => droplets.id !== id)]})
    }

    render() {
        console.log(this.state.droplets)
        return (
            <div className = "App">
                <header className="App-header"> 
                    <Table apicall = {this.state.droplets} tables = {this.state.tables} markPass = {this.markPass} delRow = {this.delRow} />
                </header>
            </div>
        );
    }
}
export default App;
