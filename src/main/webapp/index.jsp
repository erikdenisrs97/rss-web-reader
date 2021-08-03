<%@ page import="java.util.*, models.dao.*, models.* "%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Feed</title>
  </head>
  <body>
    <h1>Showing all feeds</h1>
    <div class="table-responsive">
      <table class="table table-bordered table-sm">
        <tr>
          <th>TITLE</th>
          <th>DESCRIPTION</th>
          <th>LINK</th>
        </tr>
        <%
          RSSReader rssr = new RSSReader();
          RSSdao dao = new RSSdao();
          List<RSS> feeds = dao.getFeeds();
          for(RSS feed : feeds) {
            rssr.read(feed.getLink());
          }
          List<FeedMessage> messages = rssr.getFeedMessages();
          for(FeedMessage message : messages) {
        %>
          <tr>
            <td><%= message.getTitle() %></td>
            <td><%= message.getDescription() %></td>
            <td><%= message.getLink() %></td>
          </tr>
        <%
          }
        %>
      </table>
    </div>
  </body>
</html>