from django.conf.urls import url, include
from django.views.generic import TemplateView
from . import views

app_name = 'LoginApp'
urlpatterns = [
    url(r'^signup/$', TemplateView.as_view(template_name='LoginApp/signup.html'), name='signup'),
    url(r'^signupSubmit/$', views.Signup.as_view(), name='signupSubmit'),
]
