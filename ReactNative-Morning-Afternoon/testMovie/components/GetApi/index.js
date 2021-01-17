import React from 'react';
import { View, Text, FlatList} from 'react-native';
import ListMovies from '../../containers/ListMovies'

const API_URL = "https://api.themoviedb.org/3";
const API_KEY = '921eb12322a128959478e864d44bfbca&language=en-US'

class GetApi extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            movieData: [],       
        };
    }

    componentDidMount() {
        console.log(this.props.type)
        fetch(API_URL + this.props.type + '?api_key=' + API_KEY)
            .then((response) => response.json())
            .then((responsejson) => {
            this.setState({movieData: responsejson});
            }).catch((error) => {
            console.log("fail");
        });
    }

    render() {

     
        return(
            <View>              
                {1 >0? (<FlatList
                    data={this.state.movieData.results}
                    renderItem={({ item }) => (
                        <ListMovies item = {item} navigation = {this.props.navigation} />)
                    }
                    ></FlatList>) : null}
            </View>
        )
        
    }
}

export default GetApi;

