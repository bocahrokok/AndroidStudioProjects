import 'package:flutter/material.dart';

//the main function is the starting point for all our flutter apps
void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text(" I am Fucking poor"),
          backgroundColor: Colors.greenAccent,
        ),
        body: Center(
          child: Image(
            image: AssetImage('images/catshoe.jpeg'),
          ),
        ),
        floatingActionButton: FloatingActionButton(
          onPressed: () {
            // Add your onPressed code here!
          },
          child: Icon(Icons.thumb_up),
          backgroundColor: Colors.pink,
        ),
        bottomNavigationBar: BottomAppBar(
          color: Colors.yellow,
          child: Container(height: 50.0),
        ),
        floatingActionButtonLocation: FloatingActionButtonLocation.endDocked,
      ),
    ),
  );
}
