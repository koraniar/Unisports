import React, { Component } from 'react';
import {
    AppRegistry,
    Text,
    View,
    TextInput,
    TouchableHighlight,
    AlertIOS
} from 'react-native';
import styles from '../Styles/styles'
import Loading from '../Components/Loading';
import SettingsButton from '../Components/SettingsButton';
import User from '../Models/User'

class RegisterView extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            loadingVisible: false,
            email: "",
            password: "",
            passwordConfirm: ""
        };
    };
    static navigationOptions = ({ navigation, screenProps }) => ({
        title: 'Registro',
        headerTintColor: 'white',
        headerStyle: { backgroundColor: '#EF6C00' },
        headerRight: <SettingsButton navigation={navigation} />
    });

    onRegister() {
        //this.setState({ loadingVisible: true });
        if (this.state.email == '' || this.state.password == '' || this.state.passwordConfirm == '') {
            AlertIOS.alert(
                "Error",
                "Datos no validos"
            );
            return false;
        }
        if (this.state.password != this.state.passwordConfirm) {
            AlertIOS.alert(
                "Error",
                "Las contraseñas no coinciden"
            );
            return false;
        }
        let url = 'http://unisports.azurewebsites.net/UnisportsRest/rest/Account/Register';

        var User = {
            id: '',
            name: '',
            lastName: '',
            email: '',
            contactPhone: '',
            address: '',
            bornDate: '',
            password: '',
            overalRate: '',
            excellentAverage: '',
            regularAverage: '',
            badAverage: '',    
            nonAttendanceAverage: '',
            teamList: [],
            userInscriptionList: [],
            relationshipList: [],
            notificationList: []
          };

        User.email = this.state.email;
        User.password = this.state.password;

console.log(User);

        try {
            fetch(url, {
                method: 'POST',
                body: JSON.stringify(User),
                headers: {
                    'Accept': 'application/json',
                    'content-type': 'application/json'
                }
            }).then((response) => {
                this.setState({ loadingVisible: false });
                console.log("response");
                console.log(response);
                var response = JSON.parse(response._bodyText);
                AlertIOS.alert(
                    response.result ? "Unisports" : "Error",
                    response.message
                );
            }).catch((error) => {
                console.log('error');
                console.log(error);
            });
        } catch (error) {
            console.log("error");
            console.log(error);
        }
    }

    render() {
        const { navigate } = this.props.navigation;

        return (
            <View style={styles.container}>
                <Text style={{ alignSelf: 'flex-start', marginHorizontal: 10, fontSize: 20 }}>Email:</Text>
                <TextInput
                    style={{ alignSelf: 'stretch', height: 40, borderColor: 'gray', borderBottomWidth: 1, marginHorizontal: 10, fontSize: 20 }}
                    onChangeText={(email) => this.setState({ email })} keyboardType={'email-address'}
                    value={this.state.email}
                />

                <Text style={{ alignSelf: 'flex-start', marginHorizontal: 10, marginTop: 40, fontSize: 20 }}>Contraseña:</Text>
                <TextInput
                    style={{ alignSelf: 'stretch', height: 40, borderColor: 'gray', borderBottomWidth: 1, marginHorizontal: 10, fontSize: 20 }}
                    onChangeText={(password) => this.setState({ password })} secureTextEntry={true}
                    value={this.state.password}
                />

                <Text style={{ alignSelf: 'flex-start', marginHorizontal: 10, marginTop: 40, fontSize: 20 }}>Confirmar Contraseña:</Text>
                <TextInput
                    style={{ alignSelf: 'stretch', height: 40, borderColor: 'gray', borderBottomWidth: 1, marginHorizontal: 10, fontSize: 20 }}
                    onChangeText={(passwordConfirm) => this.setState({ passwordConfirm })} secureTextEntry={true}
                    value={this.state.passwordConfirm}
                />

                <TouchableHighlight underlayColor='rgba(0,0,0,0)' style={{ marginTop: 20 }} onPress={() => { this.onRegister() }}>
                    <Text style={{ padding: 5, fontSize: 18 }}>Registrarme</Text>
                </TouchableHighlight>

                <Loading visible={this.state.loadingVisible} />
            </View>
        );
    }
}

module.exports = RegisterView;