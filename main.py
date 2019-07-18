import webapp2
import jinja2
import os

jinja_env = jinja2.Environment(
    loader=jinja2.FileSystemLoader(os.path.dirname(__file__)),
    extensions=['jinja2.ext.autoescape'],
    autoescape=True)

class htmlHandler(webapp2.RequestHandler):
    def get(self):
        template = jinja_env.get_template('templates/index.html')
        self.response.write(template.render())



class BlogHandler(webapp2.RequestHandler):
    def get(self):
        template = jinja_env.get_template('templates/new_post.html')
        self.response.write(template.render())
    def post(self):
        title_var = self.request.get('Title')
        content_var = self.request.get('Content')
        author_var = self.request.get('AuthorName')
        print(title_var)
        print(content_var)
        print(author_var)
        self.response.write('good job')

app = webapp2.WSGIApplication([
    ('/', htmlHandler),
    ('/Blog'),
], debug = True)
