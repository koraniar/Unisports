import React, { Component } from 'react';
import { StackNavigator } from 'react-navigation';
import HomeView from './src/Containers/HomeView';
import LoginView from './src/Containers/LoginView';
import RegisterView from './src/Containers/RegisterView';

const Unisports = StackNavigator({
  Login: { screen: LoginView },
  Home: { screen: HomeView },
  Register: { screen: RegisterView }
});

export default Unisports;
