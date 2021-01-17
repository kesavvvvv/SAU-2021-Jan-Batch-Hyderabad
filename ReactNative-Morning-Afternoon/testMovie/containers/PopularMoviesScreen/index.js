import React  from 'react';
import { Text, View } from 'react-native';
import GetApi from '../../components/GetApi'

const PopularMoviesScreen = ({navigation}) => {
    return (
        
            <View style={{ flex: 1,alignItems: 'center' }}>
                <GetApi type = '/movie/popular' navigation={navigation}/>
            </View>
        
    )
}

export default PopularMoviesScreen;
