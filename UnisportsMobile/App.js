import React, { Component } from 'react';
import { StackNavigator } from 'react-navigation';
import HomeView from './src/Containers/HomeView';

const Unisports = StackNavigator({
  Home: { screen: HomeView }
});

export default Unisports;
