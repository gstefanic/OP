{
  "device_name": "pi",
  "listening_port" : 0,                       // 0 - randomize port

/* storage_path dir contains auxilliary app files
   if no storage_path field: .sync dir created in the directory
   where binary is located.
   otherwise user-defined directory will be used
*/
  "storage_path" : "/opt/btsync/app_files",

// uncomment next line if you want to set location of pid file
// "pid_file" : "/var/run/btsync/btsync.pid",

  "check_for_updates" : true,
  "use_upnp" : true,                              // use UPnP for port mapping


/* limits in kB/s
   0 - no limit
*/
  "download_limit" : 0,
  "upload_limit" : 0,

/* remove "listen" field to disable WebUI
   remove "login" and "password" fields to disable credentials check
*/
  "webui" :
  {
    "listen" : "0.0.0.0:80",
    "login" : "pi",
    "password" : "raspberry"
  }

/* !!! if you set shared folders in config file WebUI will be DISABLED !!!
   shared directories specified in config file
   override the folders previously added from WebUI.
*/
/*
  ,
  "shared_folders" :
  [
    {
//  use --generate-secret in command line to create new secret
      "secret" : "MY_SECRET_1",           // * required field
      "dir" : "/opt/btsync/sync_test",    // * required field

//  use relay server when direct connection fails
      "use_relay_server" : true,
      "use_tracker" : true,
      "use_dht" : false,
      "search_lan" : true,
//  enable sync trash to store files deleted on remote devices
      "use_sync_trash" : true,
      "sync_trash_ttl" : 365,      // Default is 30 days.
//  specify hosts to attempt connection without additional search
      "known_hosts" :
      [
        "192.168.1.2:44444"
      ]
    }
  ]
*/

// Advanced preferences can be added to config file.
// Info is available in BitTorrent Sync User Guide.

// http://btsync.s3-website-us-east-1.amazonaws.com/BitTorrentSyncUserGuide.pdf

}