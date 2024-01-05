import 'package:flutter/material.dart';
import 'wise_ai_service.dart';

class HomeView extends StatefulWidget {
  const HomeView({Key? key}) : super(key: key);

  @override
  State<HomeView> createState() => _HomeViewState();

}

class _HomeViewState extends State<HomeView> {


  Future<void> _initializeWiseAI() async {
    try {
      await WiseAIService.initialize(token: "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ3aXNlYWkiLCJzdWIiOiJ3aXNlYWktYXBpIiwiaWQiOiIyMDAiLCJubSI6IkJlcnJ5UGF5IERlbW8iLCJtaXNjIjoiIiwidmVyIjozfQ.-rhngi6Z9GQJxx1Zq1gtfr9AVUTj6yPzl4KuCtm2Xtc",
      urlEndpoint: "https://wiseconsole-demo.wiseai.tech/",
      );
    } catch (e) {
      print('Failed to initialize WiseAI homeview: $e');
    }
  }

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        title: const Text('HomeView'),
        centerTitle: true,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              onPressed: () async {
                await _initializeWiseAI();
              },
              child: const Text('Initialize WiseAI'),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () async {
                await _initializeWiseAI();
              },
              child: const Text('Perform eKYC'),
            ),
          ],
        ),
      ),
    );
  }
}
