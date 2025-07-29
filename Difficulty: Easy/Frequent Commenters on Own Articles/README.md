<h2><a href="https://www.geeksforgeeks.org/problems/frequent-commenters-on-own-articles/1">Frequent Commenters on Own Articles</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO"><h2>Problem Description:</h2>
<p><span style="font-size: 14pt;">Write a solution to find all the authors who have commented on at least one of their own articles multiple times.</span></p>
<p><span style="font-size: 14pt;">Each row in the table indicates a comment made by a <strong>viewer</strong> on an <strong>article</strong> written by a <strong>specific author</strong> on a <strong>certain date</strong>. If an author comments on their own article more than once, we need to identify the author.</span></p>
<p><span style="font-size: 14pt;">Return the result table with the <strong>author_id</strong> of all authors who have commented more than once on their own article. The result table should be ordered by <strong>author_id</strong> in ascending order.</span></p>
<h3>Pandas Schema<strong>:</strong></h3>
<p><strong><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/problem_desc/Web/Other/blobid0_1747029156.png" width="353" height="258"></strong></p>
<ul>
<li>
<p><span style="font-size: 14pt;"><strong>article_id</strong>: Unique ID for each article.</span></p>
<span style="font-size: 14pt;"> </span></li>
<li><span style="font-size: 14pt;"> </span>
<p><span style="font-size: 14pt;"><strong>author_id</strong>: The unique ID of the article's author.</span></p>
<span style="font-size: 14pt;"> </span></li>
<li><span style="font-size: 14pt;"> </span>
<p><span style="font-size: 14pt;"><strong>viewer_id</strong>: The unique ID of the person who commented on the article.</span></p>
<span style="font-size: 14pt;"> </span></li>
<li><span style="font-size: 14pt;"> </span>
<p><span style="font-size: 14pt;"><strong>comment_date</strong>: The date when the comment was made</span>.</p>
</li>
</ul>
<h2>Task:</h2>
<p><span style="font-size: 14pt;">Write a solution to find all the <strong>author_id</strong> of authors who have commented <strong>more than once</strong> on their own articles.</span></p>
<h2>Example :</h2>
<h3>Input table<strong>:</strong></h3>
<p><strong><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/problem_desc/Web/Other/blobid1_1747029167.png" width="608" height="373"></strong></p>
<h3>Output table<strong>:</strong></h3>
<p><strong><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/895028/Web/Other/blobid3_1747029567.png" width="119" height="233"></strong></p>
<h3>Explanation:</h3>
<ul>
<li>
<p><span style="font-size: 14pt;"><strong>Author 3</strong>: Commented twice on their own article (article 1).</span></p>
<span style="font-size: 14pt;"> </span></li>
<li><span style="font-size: 14pt;"> </span>
<p><span style="font-size: 14pt;"><strong>Author 7</strong>: Commented twice on their own article (article 2).</span></p>
<span style="font-size: 14pt;"> </span></li>
<li><span style="font-size: 14pt;"> </span>
<p><span style="font-size: 14pt;"><strong>Author 5</strong>: Commented twice on their own article (article 5).</span></p>
</li>
</ul></div>