import React  from 'react';
import { Text, View } from 'react-native';
import GetApi from '../../components/GetApi'

const UpcomingMoviesScreen = ({navigation}) => {
    return (
        
            <View style={{ flex: 1,alignItems: 'center' }}>
                <GetApi type = '/movie/upcoming' navigation={navigation}/>
            </View>
        
    )
}

export default UpcomingMoviesScreen;