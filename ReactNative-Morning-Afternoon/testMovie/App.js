import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import TopRatedNav from './navigation/TopRatedNav'
import UpcomingMoviesNav from './navigation/UpcomingMoviesNav'
import PopularMoviesNav from './navigation/PopularMoviesNav'
import { AntDesign } from 'react-native-vector-icons';

import { createBottomTabNavigator} from '@react-navigation/bottom-tabs'


const Tab = createBottomTabNavigator();

const App = () => {
  return (
    
     <Tab.Navigator screenOptions={({ route }) => ({
      tabBarIcon: ({ focused, color, size }) => {
        if (route.name === 'Popular Movies') 
          return (<AntDesign name="heart" size={25} color="black" />);
        else if (route.name === 'Upcoming Movies') 
          return (<AntDesign name="clockcircle" size={25} color="black" />);      
        else if (route.name === 'Top Rated') 
          return (<AntDesign name="star" size={25} color="black" />);        
      }})}>
       <Tab.Screen color = "black" name="Upcoming Movies" component={UpcomingMoviesNav} />
       <Tab.Screen color = "black" name="Top Rated" component={TopRatedNav} />
       <Tab.Screen color = "black" name="Popular Movies" component={PopularMoviesNav} /> 
     </Tab.Navigator>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});

export default App;
