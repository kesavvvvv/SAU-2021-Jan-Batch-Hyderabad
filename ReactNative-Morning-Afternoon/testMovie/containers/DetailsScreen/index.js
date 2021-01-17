import React from 'react';
import { Text, View, ScrollView, Image } from 'react-native';
import { AntDesign, Feather } from 'react-native-vector-icons';

const API_URL = 'https://api.themoviedb.org/3/movie/';
const IMAGE_DOMAIN_URL = 'https://image.tmdb.org/t/p/w500/'
const API_KEY = '?api_key=921eb12322a128959478e864d44bfbca&language=en-US'

const getYear = (str) => {

    if (typeof(str) !== 'undefined' && str.length){
        return str.slice(0,4);
      }
}

const genre = (item) => {
    if (typeof(item.genres) !== 'undefined' && item.genres.length) {
      const genreArray = [];
      item.genres.map((item, index)  => {
        genreArray.push(item.name);
      })
      if(genreArray.length >3){
        genreArray.pop();
        genreArray.pop();
      }
      return(genreArray);
    }
    else{
      return(["Undefined"]);
    }
  
}

class DetailsScreen extends React.Component {

    constructor(props) {
        super(props);
    
        this.state = {
          details: [],
        }
    }

    componentDidMount() {
        fetch(API_URL + this.props.route.params.items.id + API_KEY)
            .then((response) => response.json())
            .then((responsejson) => {
            this.setState({details: responsejson});
            }).catch((error) => {
            console.log("fail");
        });
    }

    render() {
    return (
        <ScrollView style={{}}>
            
              <View style={{flexDirection:'column'}}>
                  <Image style={{height:200,width:400}} source={{uri: IMAGE_DOMAIN_URL+ this.state.details.backdrop_path}} />
                  <View style = {{flexDirection:'row'}}>
                    <Image style={{marginLeft:20, marginTop: 20, height:180,width:100}} source={{uri: IMAGE_DOMAIN_URL+ this.state.details.poster_path}} />
                        <View style = {{flexDirection:'column'}}>
                            <Text style={{marginLeft: 20, width:210,marginTop: 20, fontWeight: 'bold', fontSize:23, flexShrink: 1}}>{this.state.details.title}</Text>
                            <Text style={{marginLeft: 20}}>({getYear(this.state.details.release_date)})</Text>
                            <Text style={{marginLeft: 20, marginTop: 5}}>{this.state.details.status}</Text>
                            <View style = {{flexDirection:'row'}}>
                            { genre(this.state.details).map((item,index) => {
                                return(<Text style={{ marginLeft: 24, marginTop: 15}}>{item}</Text>);
                                }) }
                            </View>
                        </View>
                   
                  </View>
                  
                  <View style={{flexDirection:'row', marginLeft: 55, marginTop: 30}}  >
                        
                        <Text style = {{fontWeight: 'bold'}}>{this.state.details.vote_average}</Text>
                        <AntDesign style = {{marginLeft: 5, marginTop:2}} name="star" size={15} color="black" />
                        <Feather style = {{marginLeft: 80, marginTop:2}} name="globe" size={15} color="black" />
                        <Text style={{marginLeft: 7, fontWeight: 'bold'}}>{this.state.details.original_language}</Text>
                        <Text style={{marginLeft: 70, fontWeight:'bold'}}>{this.state.details.release_date}</Text>        
                    </View>       
                    <View style={{flexDirection:'row', marginLeft: 50, marginTop: 5}}  >
                        
                        <Text style = {{}}>Rating</Text>
                      
                        <Text style={{marginLeft: 70, }}>Language</Text>
                        <Text style={{marginLeft: 48, }}>Release Date</Text>        
                    </View>  

                    <View style={{flexDirection:'column', marginLeft: 25, marginTop: 30}}  >
                    <Text style = {{fontWeight: 'bold'}}>Overview</Text>
                    <Text style = {{marginTop: 20}}>{this.state.details.overview}</Text>
                        </View>  
              </View>
        
        </ScrollView>
    )
    }
}

export default DetailsScreen;
