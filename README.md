
# Android-Utility

<p>This is a library for <strong>Android</strong> application projects.</p>


<h1 class="page-header" id="howto">How to use</h1>
<div class="row">
  <div class="col-lg-12">
    <p>To get a Git project into your build:</p>
  </div>
</div>


<b>Step 1.</b> Add the JitPack repository to your build file

<p>Add it in your root build.gradle at the end of repositories:</p>
<pre class="kode language-css code-toolbar" style="background: #141414">
	<code class=" kode language-css">
		<span class="token selector" style="color: #f9ee9a">allprojects</span><span class="token punctuation">{</span>
		<span class="token selector" style="color: #f9ee9a">    repositories</span><span class="token punctuation">{</span>
			<span class="token selector" style="color: #f9ee9a">...
                        maven</span><span class="token punctuation">{</span> url <span class="token string" style="color: #919e6b">'https://jitpack.io'</span> <span class="token punctuation">}</span>
		    <span class="token punctuation">}</span>
		<span class="token punctuation">}</span>
	</code>
</pre>
    
<p><b>Step 2.</b> Add the dependency</p> 
		
<pre class="kode code-toolbar language-css" style="background: #141414">
	<code id="depCodeGradle" class=" kode  language-css">
		<span class="token selector" style="color: #f9ee9a">dependencies</span><span class="token punctuation">{</span>
	            implementation <span class="token string" style="color: #919e6b">'com.github.mostafamahmoudabdelaleem:Android-Utility:X.X.X'</span>
		<span class="token punctuation">}</span>
	</code>
</pre>
<p><b>Step 3.</b> Replace <strong>X.X.X</strong> with current version or any version you want.<p/>
                        
