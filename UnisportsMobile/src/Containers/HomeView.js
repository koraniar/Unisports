import React, { Component } from 'react';
import {
    AppRegistry,
    Text,
    View,
    FlatList,
    Animated,
    TouchableHighlight,
    Alert,
    ToastAndroid,
    NativeModules,
    AsyncStorage,
    Image
} from 'react-native';
import styles from '../Styles/styles'
import HomeCard from '../Components/HomeCard'
import Loading from '../Components/Loading';
import SettingsButton from '../Components/SettingsButton';
import RoundButton from '../Components/RoundButton'

var processId = null;

class HomeView extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            selectedState: "Open",
            loadingVisible: false,
            taskData: null,
            resultsFounds: false
        };
    };
    static navigationOptions = ({ navigation, screenProps }) => ({
        title: 'Unisports',
        headerTintColor: 'white',
        headerStyle: { backgroundColor: '#EF6C00' },
        headerRight: <SettingsButton navigation={navigation} />
    });

    componentWillMount() {
        
    }

    _keyExtractor = (item, index) => item.Id;

    reloadTaskView() {
        //this.setState({ loadingVisible: true });
        this.setState({ resultsFounds: false, taskData: "{}" });
    }

    render() {
        const { navigate } = this.props.navigation;
        _onPressCard = (id) => {
            this.setState({ loadingVisible: true });
        };
        return (
            <View style={styles.container}>
                <RoundButton bgColor="#03A9F4" style={{ position: 'absolute', zIndex: 1000, bottom: 15, right: 5 }} size={60} onPressButton={() => { navigate('Search'); }}>
                    {/* <Image source={require('../Resources/Images/search_black_48.png')} style={{ width: 30, height: 30 }} /> */}
                </RoundButton>
                <Text style={[styles.informativeSearchText, { padding: this.state.resultsFounds == true ? 0 : 30, height: this.state.resultsFounds == true ? 0 : 100 }]}>There is no events</Text>
                <FlatList
                    style={styles.ListView}
                    data={this.state.taskData}
                    keyExtractor={this._keyExtractor}
                    renderItem={({ item }) =>
                      (<HomeCard Id={item.Id} onPressDocument={_onPressDocument} Name={item.CrmTaskType.Name} Status={item.TaskStatus} onChangeStatus={_onChangeStatus}
                            CreatedDate={item.CreatedDate} Responsable={item.Responsable.FirstName + " " + item.Responsable.LastName} onStopRecord={_onStopRecord}
                            onStartRecord={_onStartRecord} DueDate={item.DueDate} ProcessId={item.CrmProcessId} EmployerName={item.EmployerName} onPressCard={_onPressCard}
                            Notificate={item.Notificate} EmployeeName={item.EmployeeName} />)
                    }
                />

                <Loading visible={this.state.loadingVisible} />
            </View>
        );
    }
}

module.exports = HomeView;