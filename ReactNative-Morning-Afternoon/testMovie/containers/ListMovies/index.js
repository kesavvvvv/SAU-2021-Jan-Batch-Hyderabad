import React from 'react';
import { View, Text, StyleSheet, Image } from 'react-native';
import { Card } from 'react-native-elements';
import { TouchableOpacity } from 'react-native-gesture-handler';

const IMAGE_DOMAIN_URL = 'https://image.tmdb.org/t/p/w500/'


const ListMovies = (props) => { 
  //  console.log(props.item)
    return(
      <View style={{width: 400}}>
          <TouchableOpacity onPress = { () => props.navigation.navigate('Details', {items: props.item})} >
        <Card>
          {            
              <View style={{flexDirection:'row', margin:10, flexShrink: 1}}>
                  <Image style={{height:180,width:100}} source={{uri: IMAGE_DOMAIN_URL+ props.item.poster_path}} />
                  <View style = {{flexDirection:'column'}}>
                      <Text style={{marginLeft: 10, width:210,fontWeight: 'bold', flexShrink: 1}}>{props.item.title}</Text>
                      <Text style={{marginLeft: 10}}>{props.item.release_date.slice(0,4)}</Text>
                      <View style={{flexDirection:'row', margin:10}}>
                          <Text style={{marginLeft: 10}}>Language: </Text>
                          <Text style={{marginLeft: 10}}>{props.item.original_language}</Text>
                      </View>
                      <View style={{flexDirection:'row', margin:10}}>
                          <Text style={{marginLeft: 10}}>Rating: </Text>
                          <Text style={{marginLeft: 10}}>{props.item.vote_average}</Text>
                      </View>
                  </View>
                  
              </View>
          }
        </Card>
        </TouchableOpacity>
      </View>
    );
}

export default ListMovies;