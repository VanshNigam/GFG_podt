<h2><a href="https://www.geeksforgeeks.org/problems/delete-duplicate-phone-numbers/1">Delete Duplicate Phone Numbers</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO"><h3><span style="font-size: 14pt;">Problem Description:</span></h3>
<p><span style="font-size: 14pt;">You are given a table <strong>Customer </strong>that contains customer information, including their unique <strong>id </strong>and their <strong>phone </strong>number. Some customers may have duplicate phone numbers, and you are supposed to delete the duplicate phone numbers, keeping only the one with the smallest <strong>id</strong>.</span></p>
<p><span style="font-size: 14pt;">Write a solution to delete all duplicate phone numbers, keeping only one unique phone number with the smallest <strong>id</strong>.</span></p>
<p><span style="font-size: 14pt;"><strong>Pandas Schema:</strong></span></p>
<p><span style="font-size: 14pt;"><strong><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/problem_desc/Web/Other/blobid0_1747034928.png" width="378" height="188"></strong></span></p>
<ul>
<li><span style="font-size: 14pt;"> </span>
<p><span style="font-size: 14pt;"><strong>id</strong>: Unique ID for each customer (Primary key).</span></p>
<span style="font-size: 14pt;"> </span></li>
<li><span style="font-size: 14pt;"> </span>
<p><span style="font-size: 14pt;"><strong>name</strong>: The name of the customer.</span></p>
<span style="font-size: 14pt;"> </span></li>
<li><span style="font-size: 14pt;"> </span>
<p><span style="font-size: 14pt;"><strong>phone</strong>: The phone number of the customer.</span></p>
<span style="font-size: 14pt;"> </span></li>
</ul>
<h3><span style="font-size: 14pt;">Task:</span></h3>
<p><span style="font-size: 14pt;">Write a solution to delete all duplicate phone numbers, keeping only one unique phone number with the smallest id. The final result should show each customer with their <strong>id</strong>, <strong>name</strong>, and <strong>phone</strong>, where each phone number appears only once with the smallest <strong>id</strong>.</span></p>
<h3><span style="font-size: 14pt;">Example 1:</span></h3>
<p><span style="font-size: 14pt;"><strong>Input table:</strong></span></p>
<p><span style="font-size: 14pt;"><strong><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/problem_desc/Web/Other/blobid1_1747035037.png" width="479" height="255"></strong></span></p>
<p><span style="font-size: 14pt;"><strong>Output table:</strong></span></p>
<p><span style="font-size: 14pt;"><strong><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/problem_desc/Web/Other/blobid2_1747035050.png" width="479" height="211"></strong></span></p>
<p><span style="font-size: 14pt;"><strong>Explanation:</strong></span></p>
<ul>
<li><span style="font-size: 14pt;"> </span>
<p><span style="font-size: 14pt;">"Rajesh Kumar" has the same phone number <strong>1234567890&nbsp;</strong>for multiple entries. We keep the entry with the smallest <strong>id </strong>(which is <strong>1</strong>).</span></p>
<span style="font-size: 14pt;"> </span></li>
<li><span style="font-size: 14pt;"> </span>
<p><span style="font-size: 14pt;">"Priya Sharma" and "Aarti Patel" have unique phone numbers, so their entries are kept as is.</span></p>
<span style="font-size: 14pt;"> </span></li>
<li><span style="font-size: 14pt;"> </span>
<p><span style="font-size: 14pt;">Duplicate entries for "Rajesh Kumar" with the same phone number are removed, keeping only the one with the smallest <strong>id</strong>.</span></p>
</li>
</ul></div>