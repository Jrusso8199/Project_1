/**
 * 
 */

let container = document.getElementById('post-container');

async function getPosts(){
	let res = await fetch('http://localhost:8080/Project1_Expenses/userScreen');
	let data = await res.json();
	populatePosts(data);
}

function populatePosts(data){
	for (postObj of data) {
        let post = document.createElement('div');
        post.innerHTML = `<h2>${postObj.username}</h2>
                      <p>${postObj.content}</p>`;
        console.log(postObj);
        container.append(post);
    }
}

document.getElementById("new-post-btn").addEventListener('click', newPost);

async function newPost(e){
	e.preventDefault();
	let req = await fetch('http://localhost:8080/SocialHubWeek4/api/session');
	let res = await req.json();
	let id = res.userId;
	let content = document.getElementById("post-content").value;
	if(!content){
		alert("You must have content for your post!");
		return;
	}
	let post = {
		userId: id,
		wallId: id,
		content: content
	}
	
	await fetch('http://localhost:8080/SocialHubWeek4/api/posts', {
		method: "POST",
		contentType: "application/json",
		body: JSON.stringify(post)
	});
	
	req = await fetch('http://localhost:8080/SocialHubWeek4/api/posts');
	let data = await req.json();
	container.innerHTML = '';
	content.value='';
	populatePosts(data);
}

let logoutbtn = document.getElementById("logout").addEventListener("click", logout);

async function logout(){
	let req = await fetch('http://localhost:8080/SocialHubWeek4/api/logout');
	let res = await req.text();
	console.log(res);
	req = await fetch('http://localhost:8080/SocialHubWeek4/api/session');
	res = await req.text();
	console.log(res);
	location.href = '../html/login.html';
}

getPosts();