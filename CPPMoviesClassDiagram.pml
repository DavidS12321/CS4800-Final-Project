@startuml
class Movie {
play()
pause()
changeVolume()
toggleSubtitles()
gotoTime()
}
class User {
+name
+currentMovie
}
interface Library {
seeAvailableMovies()
getMovie()
}
Library <|-- MainServer
Library <|-- ProxyServer
MainServer "1"*--"*" Movie
User o-- ProxyServer
ProxyServer - MainServer
@enduml