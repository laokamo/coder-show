
ajaxFirst(1);

//首页文章分页请求
function ajaxFirst(currentPage) {
    //加载时请求
    $.ajax({
        type: 'GET',
        url: '/articles',
        dataType: 'json',
        data: {
            size:5,
            page:currentPage
        },
        success: function (data) {
            //放入数据
            putInArticle(data);

            //分页
            $("#pagination").paging({
                rows:data[data.length-1]['pageSize'],//每页显示条数
                pageNum:data[data.length-1]['pageNum'],//当前所在页码
                pages:data[data.length-1]['pages'],//总页数
                total:data[data.length-1]['total'],//总记录数
                callback:function(currentPage){
                    ajaxFirst(currentPage);
                }
            });
        },
        error: function () {
            alert("获得文章信息失败！");
        }
    });
}


//填充文章
function putInArticle(data) {
    $('.articles').empty();
    var articles = $('.articles');
    $.each(data, function (index, obj) {
        if(index != (data.length) - 1){
            var center = $(
                '<article class="am-g blog-entry-article">'+
                '<div class="am-u-lg-12 am-u-md-12 am-u-sm-12 blog-entry-text">'+
                '<span> 作者 </a></span>'+
                '<span>'+obj['originalAuthor']+' </span>'+
                '<span> '+obj['publishDate']+' </span>'+
                '<h1><a href="'+obj['thisArticleUrl']+'">'+obj['articleTitle']+'</a></h1>'+
                '<p>'+obj['articleTabloid']+'</p>'+
                '<p><a href="" class="blog-continue">continue reading</a></p>'+
                '</div>'+
                '</article>'
            );
            articles.append(center);
            /*var articleTags = $('.article-tags');
            for(var i=0;i<obj['articleTags'].length;i++){
                var articleTag = $('<i class="am-icon-tag"><a class="tag" href="/tags?tag=' + obj['articleTags'][i] + '"> ' + obj['articleTags'][i] + '</a></i>');
                articleTags.eq(index).append(articleTag);
            }*/
            // var likes = $('<span class="likes"><i class="am-icon-heart"> ' + obj['likes'] + '个喜欢</i></span>');
            // articleTags.eq(index).append(likes);
        }
    })

}