from django.conf.urls import url, include
from django.views.generic import TemplateView
from . import views
from rest_framework import routers

app_name = 'LoginApp'

router = routers.DefaultRouter()
router.register(r'users', views.UserViewSet)
router.register(r'groups', views.GroupViewSet)

urlpatterns = [
    url(r'^$', TemplateView.as_view(template_name='LoginApp/index.html'), name='index'),
    url(r'^', include(router.urls)),
    url(r'^api-auth/', include('rest_framework.urls', namespace='rest_framework')),
    url(r'^signup/$', TemplateView.as_view(template_name='LoginApp/signup.html'), name='signup'),
    url(r'^signupSubmit/$', views.Signup.as_view(), name='signupSubmit'),
    url(r'^login/$', TemplateView.as_view(template_name='LoginApp/login.html'), name='login'),
    url(r'^loginSubmit/$', views.Login.as_view(), name='loginSubmit'),
    url(r'^logout/$', views.logout_view, name='logout'),
    url(r'^home/(?P<user_id>[0-9]+)$', TemplateView.as_view(template_name='LoginApp/home.html'), name='home'),
]
