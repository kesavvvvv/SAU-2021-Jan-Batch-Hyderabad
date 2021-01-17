import React from 'react';
import { createStackNavigator } from '@react-navigation/stack';

import DetailsScreen from '../../containers/DetailsScreen';

const Stack = createStackNavigator();

import TopRatedScreen from '../../containers/TopRatedScreen';


const TopRatedNav = () => {
    return (
         
       <Stack.Navigator headerMode= "none" >
         <Stack.Screen name="Home" component={TopRatedScreen} />
        <Stack.Screen name="Details" component={DetailsScreen} />
       </Stack.Navigator>

    );
}

export default TopRatedNav;