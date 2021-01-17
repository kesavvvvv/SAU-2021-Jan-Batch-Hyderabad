import React from 'react';
import { createStackNavigator } from '@react-navigation/stack';

import DetailsScreen from '../../containers/DetailsScreen';

const Stack = createStackNavigator();

import PopularMoviesScreen from '../../containers/PopularMoviesScreen';


const PopularMoviesNav = () => {
    return (
         
       <Stack.Navigator headerMode= "none" >
         <Stack.Screen name="Home" component={PopularMoviesScreen} />
        <Stack.Screen name="Details" component={DetailsScreen} />
       </Stack.Navigator>

    );
}

export default PopularMoviesNav;