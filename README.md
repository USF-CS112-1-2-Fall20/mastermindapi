Hangman API for Google Cloud App Engine
============================

This code should work for Java8 or Java11. You also need Maven and Google Cloud installed.

* [Maven](https://maven.apache.org/download.cgi) (at least 3.5)
* [Google Cloud SDK](https://cloud.google.com/sdk/) (aka gcloud)


### Running locally

    mvn appengine:run

To use visit: http://localhost:8080/

### Deploying

    mvn appengine:deploy

To use visit:  https://YOUR-PROJECT-ID.appspot.com

### Running with Thunkable Front End

This API can be used by any web or app client (front-end). Here is a sample
Thunkable client: https://x.thunkable.com/copy/ceb4de10aa8fe039381ea377eb6dc032

To run it, open the link above and in the Blocks change the URL to yours.

