##[The flow chart](https://app.diagrams.net/?lightbox=1&highlight=0000ff&edit=_blank&layers=1&nav=1&title=gpx_track_online#RzZfbctowEIafxpfp%2BAxcEkia6aRTWqZTkpuObG9sNbLlkcWpT18Jy0a2QkNTmMAN3l8Hr779JYHlTfLNR4bK7DNNgFiunWwsb2q5rmuHofiSyrZWHMcb1krKcKK0vTDHv0GJtlKXOIGq05FTSjguu2JMiwJi3tEQY3Td7fZESfetJUrBEOYxIqb6Ayc8a5Zh2%2FuGO8Bppl49DFRDhOLnlNFlod5nud7T7lM356iZS%2FWvMpTQtSZ5N5Y3YZTy%2BinfTIBIuA22etztgdY2bwYFP2bAYPrr8Q6538af4p8j%2F2o9%2Ffr8cOXWs6wQWSoe3ytgKmG%2BbSCJ3Ev5uMzJOOaUWd71ChjHAuM9ioDMaIU5poXoElHOaa51GBOcygZOS6FmPCcicMQjXXKCC5i0hbWFqPIRY2FzcKFOi0%2F4EmgOnG1FFzWgKVDjSE%2FF6315GynTChsqDSlDpe3Ee6jiQXH9B8a%2BwfiW0YKDME6fs0YnQVUGiaKyzjCHqkSx7LcWO%2FE0pFpvNqh8E1W7EXRWwblYBQarKeIoQhUc9GS8FS5KgDWY5l1MGtJIblZI7qNWaLfwl9qLSj8B2oHXQ%2BsGBtrwBbLDc5ENDbLXYvUXYEJ%2FdGkmdByDlQFJgBvL20cakKCqwrGgUXHEuClrQGGD%2BULy%2FBCo6KETTTcK9i7YasEMGBbLkz7XDkpIjNutx11kTZcshtcuAbM%2BGv%2FgL%2FgZEMTxqpvGSzVRb5hRLBJsy9%2BWtin%2FqFfWOn01Sr%2FfehMZh1n%2FQBfFSYEbE%2B0s0i77P1xj3qUnc00hUls0ZpCB5hoZ7m2zi3TfLDTnHeO1E%2FpKXXw199eOpvfynxd2bePab%2FSf7%2FT81z%2Bfzu0%2F7%2BL8d0IvhUd6KXhPLwWDnpfeepaFvbPM9U%2FlJUv%2B%2BGz%2BctTd93%2FsvJs%2F)



## A Story of Passionate Software Engineer
You have an idea develop a website which allow users to store and share GPS track online (similar to http://www.trackprofiler.com/track/index). After discussion with your team, they helped you to came up with some mock-up files. 
Front-end side will be developed by another team member. You are the only one who is going to be in charge of the backend service development.

Because you are so excited to show the idea to your CEO, you decided to reduce the scope and focus one developing 1 WS API with three endpoints:

- An endpoint that allow users to upload "gpx" file and store mandatory information such as "metadata, waypoint, track" 
- An endpoint to return a list of "Latest track" from our users
- An endpoint to allow users to view details of their gpx file

Although this is a prototype version, but you are a professional software engineer. You don't allow yourself to code without a System Diagram or Workflow Diagram, or produce "dirty-code" and code without Unit Tests. Additionally, since this is a fairly small and simple project, you are not allowed to use the Lombok library.

Once your have completed your solution, please upload them to Github.

This is all you have right now: 

- https://en.wikipedia.org/wiki/GPS_Exchange_Format
- Mock-up files
- A sample gpx file
- A passionate heart, if you don't like the given mock-up files, feel free to change and show your CEO a better version
- Your team is a big fan of "Spring IO" tech stack, so they prefers you use Sprint Boot as a starting point
- An in-memory database is enough for this moment (H2)