(this["webpackJsonpreact-typescript"]=this["webpackJsonpreact-typescript"]||[]).push([[0],{36:function(e){e.exports=JSON.parse('[{"id":"1","name":"Angular 4x","time":"30h","free":true,"desc":"Angular is complicated","lessons":[{"id":"1","name":"Basic Angular"},{"id":"2","name":"Advance Angular"},{"id":"3","name":"Summary Angular"}]},{"id":"2","name":"NodeJs","time":"55h","free":false,"courseName":"NodeJs","lessons":[{"id":"4","name":"Basic NodeJs"},{"id":"5","name":"Advance NodeJs"},{"id":"6","name":"Summary NodeJs"}]},{"id":"3","name":"ReactJS","time":"40h","free":true,"desc":"ReactJS is simple","lessons":[{"id":"7","name":"Basic ReactJS"},{"id":"8","name":"Advance ReactJS"},{"id":"9","name":"Extrame ReactJS"},{"id":"10","name":"Summary ReactJS"}]}]')},38:function(e,t,a){e.exports=a(67)},43:function(e,t,a){},67:function(e,t,a){"use strict";a.r(t);var n=a(0),r=a.n(n),l=a(15),s=a.n(l),o=(a(43),a(1)),i=a(2),c=a(4),u=a(3),m=a(16),h=a(18),p=a(6),d=a(33),f=a.n(d).a.create({baseURL:"/api",headers:{"content-type":"application/json; charset=utf-8"}});f.interceptors.request.use((function(e){return sessionStorage.getItem("token")&&(e.headers["x-token"]="Bearer "+sessionStorage.getItem("token")),e}));var b=f,g=function(){function e(){Object(o.a)(this,e)}return Object(i.a)(e,[{key:"login",value:function(e){return b.post("/public/login",JSON.stringify(e))}},{key:"refreshToken",value:function(){var e=sessionStorage.getItem("token");return e?b.post("/public/refresh",e):null}}]),e}(),v=r.a.createContext,E=r.a.Component,k=(r.a.useContext,v({authState:{token:"",currentUser:""},displayToken:function(){},login:function(e,t){}})),N=function(e){Object(c.a)(a,e);var t=Object(u.a)(a);function a(e){var n;return Object(o.a)(this,a),(n=t.call(this,e)).state={token:null,currentUser:null},n}return Object(i.a)(a,[{key:"render",value:function(){var e=this;return r.a.createElement(k.Provider,{value:{authState:{token:this.state.token,currentUser:this.state.currentUser},displayToken:function(){console.log("Token: "+e.state.token)},login:function(t,a){e.setState({token:a.token,currentUser:t})}}},this.props.children)}}]),a}(E),O=function(){function e(){Object(o.a)(this,e),this.loginService=new g}return Object(i.a)(e,[{key:"intervalRefreshToken",value:function(e){var t=this,a=e-(new Date).getTime()-6e4;a=6e4>a?6e4:a,console.log(a),setInterval((function(){var e=t.loginService.refreshToken();e?e.then((function(e){var t=e.data;console.log("new Token: "+t.token),console.log("ntokenExpirationTime: "+t.expirationDate),sessionStorage.setItem("token",t.token),sessionStorage.setItem("tokenExpirationTime",t.expirationDate)})).catch((function(e){console.log(e)})):console.log("Cannot refresh token")}),a)}}]),e}(),y=function(e){Object(c.a)(a,e);var t=Object(u.a)(a);function a(e){var n;return Object(o.a)(this,a),(n=t.call(this,e)).loginService=new g,n.intervalService=new O,n.state={isRedirectToReffer:!1},n.handleLogin=n.handleLogin.bind(Object(p.a)(n)),n.handleChangeInput=n.handleChangeInput.bind(Object(p.a)(n)),n.state={userName:null,passWord:null},n}return Object(i.a)(a,[{key:"handleChangeInput",value:function(e){var t=e.target.name,a=e.target.value;this.setState(Object(h.a)({},t,a))}},{key:"refreshToken",value:function(e){this.intervalService.intervalRefreshToken(e)}},{key:"handleLogin",value:function(e,t){var a=this;e.preventDefault();var n={passWord:this.state.passWord,userName:this.state.userName};this.loginService.login(n).then((function(e){var r=e.data;t.login(n.userName,r),sessionStorage.setItem("token",r.token),sessionStorage.setItem("tokenExpirationTime",r.expirationDate),a.refreshToken(r.expirationDate),t.displayToken(),a.setState({isRedirectToReffer:!0})})).catch((function(e){console.log(e)}))}},{key:"render",value:function(){var e=this,t=this.state.isRedirectToReffer,a=(this.props.location.state||{from:{pathname:"/"}}).from;return t?r.a.createElement(m.b,{to:a.pathname}):r.a.createElement("div",{className:"simple-login-container"},r.a.createElement("h2",null,"Login Form"),r.a.createElement(k.Consumer,null,(function(t){return r.a.createElement("form",{onSubmit:function(a){return e.handleLogin(a,t)}},r.a.createElement("div",{className:"row"},r.a.createElement("div",{className:"col-md-12 form-group"},r.a.createElement("input",{name:"userName",type:"text",onChange:function(t){return e.handleChangeInput(t)},className:"form-control",placeholder:"Username"}))),r.a.createElement("div",{className:"row"},r.a.createElement("div",{className:"col-md-12 form-group"},r.a.createElement("input",{name:"passWord",type:"password",onChange:function(t){return e.handleChangeInput(t)},placeholder:"Enter your Password",className:"form-control"}))),r.a.createElement("div",{className:"row"},r.a.createElement("div",{className:"col-md-12 form-group"},r.a.createElement("button",{type:"submit",className:"btn btn-block btn-login"},"Login"))))})))}}]),a}(n.Component),j=function(e){Object(c.a)(a,e);var t=Object(u.a)(a);function a(){return Object(o.a)(this,a),t.apply(this,arguments)}return Object(i.a)(a,[{key:"render",value:function(){return r.a.createElement("li",{className:"list-group-item"},this.props.lessonsName)}}]),a}(n.Component),S=a(11),C=a(13),T=a(17),R={position:T.b.POSITION.TOP_CENTER,autoClose:3e3,draggable:!1},w=function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{};return T.b.error(e,Object(C.a)(Object(C.a)({},t),R))},x=function(e){Object(c.a)(a,e);var t=Object(u.a)(a);function a(e){var n;return Object(o.a)(this,a),(n=t.call(this,e)).userNameRef=void 0,n.handleClick3=n.handleClick3.bind(Object(p.a)(n)),n.register=n.register.bind(Object(p.a)(n)),n.userNameRef=r.a.createRef(),n.handleToogleOutline=n.handleToogleOutline.bind(Object(p.a)(n)),n.handleClickTitle=n.handleClickTitle.bind(Object(p.a)(n)),n.state={isShowOutline:!1,courseBody:[],isBlocking:!1,reDirectToRegisterPage:!1},n}return Object(i.a)(a,[{key:"handleClick1",value:function(){alert("click1")}},{key:"handleClick2",value:function(e){alert(e)}},{key:"handleClick3",value:function(){alert(this.props.name)}},{key:"register",value:function(e){var t=this.userNameRef.current.value;e.preventDefault(),t?this.setState({isBlocking:!1,reDirectToRegisterPage:!0}):w("Cannot leave username!!")}},{key:"handleToogleOutline",value:function(){this.setState({isShowOutline:!this.state.isShowOutline})}},{key:"componentWillMount",value:function(){}},{key:"handleClickTitle",value:function(){this.props.onChangeTitle(this.props.name)}},{key:"setIsBlockingState",value:function(e){this.setState({isBlocking:e.target.value.length>0})}},{key:"showButtonFree",value:function(){var e=this;return this.props.free?r.a.createElement("div",{className:"btn-group"},r.a.createElement("button",{type:"button",onClick:this.handleClick1,className:"btn btn-danger"},"Left"),r.a.createElement("button",{type:"button",onClick:function(){return e.handleClick2("View 2")},className:"btn btn-warning"},"Middle"),r.a.createElement("button",{type:"button",onClick:this.handleClick3,className:"btn btn-info"},"Right"),r.a.createElement("button",{type:"button",onClick:this.handleClickTitle,className:"btn btn-success"},"ChangeTitle")):r.a.createElement("form",{onSubmit:function(t){return e.register(t)}},r.a.createElement("div",{className:"input-group"},r.a.createElement("span",{className:"input-group-btn"},r.a.createElement("button",{className:"btn btn-info",type:"submit"},"Register!")),r.a.createElement("input",{type:"text",onChange:function(t){return e.setIsBlockingState(t)},className:"form-control",placeholder:"UserName",ref:this.userNameRef})))}},{key:"render",value:function(){var e;if(this.state.reDirectToRegisterPage)return r.a.createElement(m.b,{to:"/register/"+this.userNameRef.current.value});if(this.state.isShowOutline){var t=this.props.lessons.map((function(e,t){return r.a.createElement(j,{key:t,lessonsName:e.name})}));e=r.a.createElement("ul",{className:"list-group"},t)}return r.a.createElement("div",{className:"col-xs-4 col-sm-4 col-md-4 col-lg-4"},r.a.createElement(m.a,{when:this.state.isBlocking,message:function(e){return"Are you sure you want to go to ".concat(e.pathname)}}),r.a.createElement("div",{className:"panel panel-info"},r.a.createElement("div",{className:"panel-heading"},r.a.createElement("h3",{className:"panel-title"},this.props.name)),r.a.createElement("div",{className:"panel-body"},r.a.createElement("p",null,this.props.time),r.a.createElement("p",null,this.props.children),r.a.createElement("div",{className:"btn-group"},r.a.createElement("p",null,r.a.createElement("button",{type:"button",onClick:this.handleToogleOutline,className:"btn btn-success"},"Toogle outline"),r.a.createElement(S.b,{to:"/detail/"+this.props.courseId,className:"btn btn-default"},"See details"))),e),r.a.createElement("div",{className:"panel-footer"},this.showButtonFree())))}}]),a}(n.Component),I=function(e){Object(c.a)(a,e);var t=Object(u.a)(a);function a(){return Object(o.a)(this,a),t.apply(this,arguments)}return Object(i.a)(a,[{key:"render",value:function(){return r.a.createElement("div",{className:"page-header"},r.a.createElement("h1",null,this.props.mainTitle,r.a.createElement("br",null),r.a.createElement("small",null,this.props.subTitle)))}}]),a}(n.Component),U=a(36),B=function(e){Object(c.a)(a,e);var t=Object(u.a)(a);function a(e){var n;return Object(o.a)(this,a),(n=t.call(this,e)).handleChangeTitle=n.handleChangeTitle.bind(Object(p.a)(n)),n.state={mainTitle:"Main Title",subTitle:"Sub Title"},n}return Object(i.a)(a,[{key:"handleChangeTitle",value:function(e){this.setState({mainTitle:e,subTitle:e})}},{key:"render",value:function(){var e=this,t=U.map((function(t,a){return r.a.createElement(x,{key:a,courseId:t.id,name:t.name,time:t.time,free:t.free,lessons:t.lessons,onChangeTitle:function(t){return e.handleChangeTitle(t)}}," ",t.desc," ")}));return r.a.createElement("div",null,r.a.createElement(I,{mainTitle:this.state.mainTitle,subTitle:this.state.subTitle}),r.a.createElement("div",{className:"row"},t))}}]),a}(n.Component),F=function(e){Object(c.a)(a,e);var t=Object(u.a)(a);function a(){return Object(o.a)(this,a),t.apply(this,arguments)}return Object(i.a)(a,[{key:"render",value:function(){return r.a.createElement("div",{className:"page-header"},r.a.createElement("h1",null,"Not found 404"))}}]),a}(n.Component),J=function(e){Object(c.a)(a,e);var t=Object(u.a)(a);function a(){return Object(o.a)(this,a),t.apply(this,arguments)}return Object(i.a)(a,[{key:"render",value:function(){var e=this.props.match.params.cid;return r.a.createElement("div",null,r.a.createElement("div",{className:"panel panel-info"},r.a.createElement("div",{className:"panel-heading"},r.a.createElement("h3",{className:"panel-title"},e)),r.a.createElement("div",{className:"panel-body"})))}}]),a}(n.Component),D={registerUser:function(e){return b.post("/public/registerUser",JSON.stringify(e))}},A=function(e){Object(c.a)(a,e);var t=Object(u.a)(a);function a(e){var n;return Object(o.a)(this,a),(n=t.call(this,e)).state={txtUserName:n.props.match.params.userName,txtFullName:null,txtEmail:null,isBlocking:!1,isRedirectToSuccessPages:!1,response:null},n.handleInputChange=n.handleInputChange.bind(Object(p.a)(n)),n.handleSubmitRegisterForm=n.handleSubmitRegisterForm.bind(Object(p.a)(n)),n}return Object(i.a)(a,[{key:"handleSubmitRegisterForm",value:function(e){var t=this;e.preventDefault();var a={name:this.state.txtUserName,fullName:this.state.txtFullName,email:this.state.txtEmail};D.registerUser(a).then((function(e){console.log(e),t.setState({isRedirectToSuccessPages:!0,response:e})})).catch((function(e){console.log(e)}))}},{key:"handleInputChange",value:function(e){this.setState({isBlocking:e.target.value.length>0});var t=e.target,a=t.name,n=t.value;this.setState(Object(h.a)({},a,n))}},{key:"render",value:function(){var e=this;if(this.state.isRedirectToSuccessPages){var t="/registerSuccess/"+this.state.txtUserName,a=this.state.response.data;return r.a.createElement(m.b,{to:{pathname:t,state:{response:a}}})}var n=this.props.match.params.userName;return r.a.createElement("div",null,r.a.createElement(m.a,{when:this.state.isBlocking,message:function(e){return"Are you sure you want to go to ".concat(e.pathname)}}),r.a.createElement("form",{onSubmit:function(t){return e.handleSubmitRegisterForm(t)}},r.a.createElement("legend",null,"Register Form For User: ",n),r.a.createElement("div",{className:"form-group"},r.a.createElement("label",{htmlFor:"txtUserName"},"User Name"),r.a.createElement("input",{onChange:function(t){return e.handleInputChange(t)},type:"text",className:"form-control",name:"txtUserName",placeholder:"User Name",value:n,disabled:!0})),r.a.createElement("div",{className:"form-group"},r.a.createElement("label",{htmlFor:"txtFullName"},"Full Name"),r.a.createElement("input",{onChange:function(t){return e.handleInputChange(t)},type:"text",className:"form-control",name:"txtFullName",placeholder:"Full Name"})),r.a.createElement("div",{className:"form-group"},r.a.createElement("label",{htmlFor:"txtEmail"},"Email"),r.a.createElement("input",{onChange:function(t){return e.handleInputChange(t)},type:"email",className:"form-control",name:"txtEmail",placeholder:"Email"})),r.a.createElement("button",{type:"submit",className:"btn btn-primary"},"Submit")))}}]),a}(n.Component),P=function(e){Object(c.a)(a,e);var t=Object(u.a)(a);function a(){return Object(o.a)(this,a),t.apply(this,arguments)}return Object(i.a)(a,[{key:"render",value:function(){var e=this.props.match.params.userName,t=this.props.location.state.response;return r.a.createElement("div",null,r.a.createElement("div",{className:"page-header"},r.a.createElement("h1",null,"Register Success!")),r.a.createElement("div",{className:"panel panel-info"},r.a.createElement("div",{className:"panel-heading"},r.a.createElement("h3",{className:"panel-title"},"Login Information")),r.a.createElement("div",{className:"panel-body"},r.a.createElement("div",{className:"table-responsive"},r.a.createElement("table",{className:"table table-bordered table-hover"},r.a.createElement("thead",null,r.a.createElement("tr",null,r.a.createElement("th",null,"userName"),r.a.createElement("th",null,"Password"))),r.a.createElement("tbody",null,r.a.createElement("tr",null,r.a.createElement("td",null,e),r.a.createElement("td",null,t))))))))}}]),a}(n.Component),L=a(37),W=function(e){e.component;var t=Object(L.a)(e,["component"]);return r.a.createElement(m.c,Object.assign({},t,{render:function(e){return sessionStorage.getItem("token")?r.a.createElement(r.a.Component,e):r.a.createElement(m.b,{to:{pathname:"/login",state:{from:e.location}}})}}))},M=function(e){Object(c.a)(a,e);var t=Object(u.a)(a);function a(){return Object(o.a)(this,a),t.apply(this,arguments)}return Object(i.a)(a,[{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement(m.e,null,r.a.createElement(m.c,{exact:!0,path:"/",component:B}),r.a.createElement(m.c,{path:"/login",component:y}),r.a.createElement(m.c,{path:"/register/:userName",component:A}),r.a.createElement(m.c,{path:"/registerSuccess/:userName",component:P}),r.a.createElement(W,{path:"/detail/:cid",component:J}),r.a.createElement(m.c,{component:F})))}}]),a}(n.Component),q=function(e){Object(c.a)(a,e);var t=Object(u.a)(a);function a(){return Object(o.a)(this,a),t.apply(this,arguments)}return Object(i.a)(a,[{key:"render",value:function(){return r.a.createElement("div",{className:"navbar"},r.a.createElement("ul",{className:"nav navbar-nav"},r.a.createElement("li",{className:"active"},r.a.createElement(S.b,{to:"/"},"Home")),r.a.createElement("li",{className:"active"},r.a.createElement(S.b,{to:"/login"},"Login"))))}}]),a}(n.Component),H=(a(66),function(e){Object(c.a)(a,e);var t=Object(u.a)(a);function a(){var e;Object(o.a)(this,a);for(var n=arguments.length,r=new Array(n),l=0;l<n;l++)r[l]=arguments[l];return(e=t.call.apply(t,[this].concat(r))).intervalService=new O,e}return Object(i.a)(a,[{key:"componentDidMount",value:function(){this.restoreInterval()}},{key:"restoreInterval",value:function(){console.log("restoreInterval");var e=sessionStorage.getItem("token"),t=sessionStorage.getItem("tokenExpirationTime");e&&t&&this.intervalService.intervalRefreshToken(Number.parseInt(t))}},{key:"render",value:function(){return r.a.createElement(N,null,r.a.createElement(S.a,null,r.a.createElement(q,null),r.a.createElement(M,null),r.a.createElement(T.a,null)))}}]),a}(n.Component));Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));s.a.render(r.a.createElement(r.a.StrictMode,null,r.a.createElement(H,null)),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()})).catch((function(e){console.error(e.message)}))}},[[38,1,2]]]);
//# sourceMappingURL=main.59dd5486.chunk.js.map