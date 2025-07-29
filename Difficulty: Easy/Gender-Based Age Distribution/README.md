<h2><a href="https://www.geeksforgeeks.org/problems/gender-based-age-distribution/1">Gender-Based Age Distribution</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO"><h3 class="" data-start="2056" data-end="2080"><span style="font-size: 14pt;">Problem Description:</span></h3>
<p class="" data-start="2082" data-end="2142"><span style="font-size: 14pt;">Write a solution to find the <strong data-start="2111" data-end="2121">median</strong> age for each gender.</span></p>
<p class="" data-start="2144" data-end="2271"><span style="font-size: 14pt;">Each row in the table represents a person’s <strong data-start="2188" data-end="2195">age</strong> and <strong data-start="2200" data-end="2210">gender</strong>. Your task is to compute the <strong data-start="2240" data-end="2254">median age</strong> for each gender.</span></p>
<p class="" data-start="2273" data-end="2338"><span style="font-size: 14pt;">Return the result table ordered by <strong data-start="2308" data-end="2318">gender</strong> in ascending order.</span></p>
<h3 class="" data-start="2340" data-end="2355"><span style="font-size: 14pt;">SQL Schema:</span></h3>
<p><span style="font-size: 14pt;"><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/problem_desc/Web/Other/blobid0_1747032105.png" width="356" height="231"></span></p>
<ul data-start="2572" data-end="2681">
<li class="" data-start="2572" data-end="2615"><span style="font-size: 14pt;"> </span>
<p class="" data-start="2574" data-end="2615"><span style="font-size: 14pt;"><strong data-start="2574" data-end="2587">person_id</strong>: Unique ID for each person.</span></p>
<span style="font-size: 14pt;"> </span></li>
<li class="" data-start="2616" data-end="2651"><span style="font-size: 14pt;"> </span>
<p class="" data-start="2618" data-end="2651"><span style="font-size: 14pt;"><strong data-start="2618" data-end="2628">gender</strong>: Gender of the person.</span></p>
<span style="font-size: 14pt;"> </span></li>
<li class="" data-start="2652" data-end="2681"><span style="font-size: 14pt;"> </span>
<p class="" data-start="2654" data-end="2681"><span style="font-size: 14pt;"><strong data-start="2654" data-end="2661">age</strong>: Age of the person.</span></p>
<span style="font-size: 14pt;"> </span></li>
</ul>
<h3 class="" data-start="2683" data-end="2692"><span style="font-size: 14pt;">Task:</span></h3>
<p class="" data-start="2694" data-end="2754"><span style="font-size: 14pt;">Write a solution to find the <strong data-start="2723" data-end="2737">median age</strong> for each gender.</span></p>
<h3 class="" data-start="2756" data-end="2768"><span style="font-size: 14pt;">Example:</span></h3>
<p class="" data-start="2770" data-end="2780"><span style="font-size: 14pt;"><strong data-start="2770" data-end="2780">Input:</strong></span></p>
<p class="" data-start="2770" data-end="2780"><span style="font-size: 14pt;"><strong data-start="2770" data-end="2780"><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/problem_desc/Web/Other/blobid1_1747032116.png" width="414" height="363"></strong></span></p>
<p class="" data-start="2770" data-end="2780"><strong style="font-size: 14pt;" data-start="3094" data-end="3105">Output:</strong></p>
<p class="" data-start="2770" data-end="2780"><strong style="font-size: 14pt;" data-start="3094" data-end="3105"><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/895039/Web/Other/blobid5_1747032524.png" width="320" height="215"></strong></p>
<p class="" data-start="3257" data-end="3273"><span style="font-size: 14pt;"><strong data-start="3257" data-end="3272">Explanation</strong>:</span></p>
<p><span style="font-size: 14pt;"> </span></p>
<ul data-start="3274" data-end="3477">
<li class="" data-start="3274" data-end="3374"><span style="font-size: 14pt;"> </span>
<p class="" data-start="3276" data-end="3374"><span style="font-size: 14pt;"><strong data-start="3276" data-end="3288">M (Male)</strong>: The median age is 25 since the middle value in the sorted ages [23, 25, 28]&nbsp;is <strong>25</strong>.</span></p>
<span style="font-size: 14pt;"> </span></li>
<li class="" data-start="3375" data-end="3477"><span style="font-size: 14pt;"> </span>
<p class="" data-start="3377" data-end="3477"><span style="font-size: 14pt;"><strong data-start="3377" data-end="3391">F (Female)</strong>: The median age is 27 since the middle value in the sorted ages [22, 27, 30] is <strong>27</strong>.</span></p>
</li>
</ul></div>