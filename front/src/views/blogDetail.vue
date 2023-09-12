<template>
    <div>
        <div class="mblog">
            <h2> {{ blog.title }}</h2>
            <el-link icon="el-icon-edit">
                <router-link :to="{ path: '/blogUpdate', query: { blogId: blog.id } }">
                    编辑
                </router-link>
            </el-link>
            <el-divider></el-divider>
            <div class="markdown-body" v-html="blog.content"></div>

        </div>

    </div>
</template>

<script>
import axios from "axios"
import 'github-markdown-css'

export default {
    name: "BlogDetail.vue",
    components: {  },
    data() {
        return {
            blog: {
                id: "",
                title: "",
                content: ""
            }
        }
    },
    created() {
        const blogId = this.$route.query.blogId
        console.log(blogId)
        const _this = this
        axios.get('/blog/id?id=' + blogId).then(res => {
            const blog = res.data
            console.log(res)
            _this.blog.id = blog.id
            _this.blog.title = blog.title

            var MardownIt = require("markdown-it")
            var md = new MardownIt()

            var result = md.render(blog.content)
            _this.blog.content = result
        })
    }
}
</script>

<style scoped>
.mblog {
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    width: 100%;
    min-height: 700px;
    padding: 20px 15px;
}
</style>