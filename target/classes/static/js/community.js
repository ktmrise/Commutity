function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    console.log(questionId);
    console.log(content);
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId": questionId,
            "content": content,
            "type": 1
        }),
        success: function (response) {
            if (response.code == 200) {
                $("#comment_segment").hide();
            } else if(response.code==2003){
                var isAccept = confirm(response.message);
                if (isAccept) {
                    window.open("https://github.com/login/oauth/authorize?client_id=cb84998b2c611202cf0b&redirect_uri=http://localhost:80/callback&sser&state=1");
                    window.localStorage.setItem("closable", "true");
                }
            }
        },
        dataType: "json"
    });
}