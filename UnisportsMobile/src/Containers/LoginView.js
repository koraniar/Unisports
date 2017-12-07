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

class LoginView extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            loadingVisible: false,
            email: "",
            password: ""
        };
    };
    static navigationOptions = ({ navigation, screenProps }) => ({
        title: 'Login',
        headerTintColor: 'white',
        headerStyle: { backgroundColor: '#EF6C00' },
        headerRight: <SettingsButton navigation={navigation} />
    });

    onLogin() {
        //this.setState({ loadingVisible: true });
        if(this.state.email == '' || this.state.password == ''){
            AlertIOS.alert(
                "Error",
                "Datos no validos"
               );
            return false;
        }
        let url = 'http://unisports.azurewebsites.net/UnisportsRest/rest/Auth/Login?email=' + this.state.email + '&password=' + this.state.password;

        try {
            fetch(url, {
                method: 'GET',
                body: '',
                headers: {
                    'Accept': 'application/json',
                }
            }).then((response) => {
                this.setState({ loadingVisible: false });
                console.log("response");
                var response = JSON.parse(response._bodyText);
                AlertIOS.alert(
                    response.result ? "Unisports" : "Error",
                    response.result ? "Entrando..." : response.message
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

                <TouchableHighlight underlayColor='rgba(0,0,0,0.5)' style={{ marginTop: 20 }} onPress={() => { this.onLogin() }}>
                    <Text style={{ padding: 5, fontSize: 18 }}>Iniciar Sesión</Text>
                </TouchableHighlight>

                <TouchableHighlight underlayColor='rgba(0,0,0,0.5)' style={{ marginTop: 30 }} onPress={() => { navigate('Register'); }}>
                    <Text style={{ padding: 5, fontSize: 14 }}>No tengo cuenta</Text>
                </TouchableHighlight>

                <Loading visible={this.state.loadingVisible} />
            </View>
        );
    }
}

module.exports = LoginView;