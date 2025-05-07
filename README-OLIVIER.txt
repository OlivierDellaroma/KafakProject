PRe-INSTAL : 
aller dans : https://kafka.apache.org/downloads
telecharger : https://archive.apache.org/dist/kafka/3.5.1/kafka_2.13-3.5.1.tgz

installer kafka_2.13-3.5.1 par exemple dab=nc un repertoire : c:\tools\kafka_2.13-3.5.1\

Voir le cours youtube : https://www.youtube.com/watch?v=2rDKBhoaZPw

1. lancer Windows Terminal (Terminal avec plusier onglets)
2. se positionner dans le dssier kafka/bin/windows/
3. lancer zookeeper : ligne de commande ci-dessous
   C:\tools\kafka_2.13-3.5.1\bin\windows> .\zookeeper-server-start.bat ..\..\config\zookeeper.properties

4. lancer kafka: ligne de commande ci-dessous
   C:\tools\kafka_2.13-3.5.1\bin\windows> .\kafka-server-start.bat ..\..\config\server.properties

5. creer un topic : 
   C:\tools\kafka_2.13-3.5.1\bin\windows> .\kafka-topics.bat --create --topic kafka-formation --bootstrap-server localhost:9092



Si on veut tester rapidement un producer et consummer : 

lancer le producer : 
C:\tools\kafka_2.13-3.5.1\bin\windows> .\kafka-console-producer.bat --topic kafka-formation --bootstrap-server localhost:9092

lancer un consummer  
C:\tools\kafka_2.13-3.5.1\bin\windows> .\kafka-console-consumer.bat --topic kafka-formation --bootstrap-server localhost:9092 --from-beginning

la main vous sera donner pour envoyer un message : exemple ecriver TEST OLIVER  dans la fenetre du producer et le message devrait apparaitre dans la fentre du CONSUMER

Si on veut cree un producer et consummer en java spring boot Voir le projet KafkaProject



