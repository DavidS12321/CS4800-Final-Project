@startuml
class VideoStreamingApp {
login() : User
logout()
createUser()
}
class Video {
play()
pause()
changeVolume()
toggleSubtitles()
scrubTo()
}
class User {
getCurrentVideo()
setPassword()
getUserName()
sendPaymentReminder()
payAmount()
deleteAccount()
}
interface Library {
seeAvailableVideos()
getVideo()
addVideo()
removeVideo()
}
VideoStreamingApp "1" o-- "*" User
Library <|-- MainServer
Library <|-- ProxyServer
MainServer "1"*--"*" Video
User "*" o-- "1" ProxyServer
ProxyServer "*"--"*" ProxyServer
ProxyServer "*"--"0-1" MainServer
User "*" o-- "0-1" Video
ProxyServer : retrieveVideo()
@enduml