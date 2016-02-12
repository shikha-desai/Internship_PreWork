from REST.models import REST
from REST.serializers import RESTSerializer, UserSerializer
from rest_framework import generics, permissions, renderers, viewsets
from django.contrib.auth.models import User
from REST.permissions import IsOwnerOrReadOnly
import logging
from django.http import HttpResponseRedirect, HttpResponse
from django.views.generic import View
from rest_framework.decorators import api_view, detail_route
from rest_framework.response import Response
from rest_framework.reverse import reverse
import os
from newApp import settings
from shutil import copyfile


# @api_view(('GET',))
# def api_root(request, format=None):
#     return Response({
#         'users': reverse('user-list', request=request, format=format),
#         'snippets': reverse('rest-list', request=request, format=format)
#     })


class DetailViewSet(viewsets.ModelViewSet):
    """
    This viewset automatically provides `list`, `create`, `retrieve`,
    `update` and `destroy` actions.

    Additionally we also provide an extra `highlight` action.
    """
    queryset = REST.objects.all()
    serializer_class = RESTSerializer
    permission_classes = (permissions.IsAuthenticatedOrReadOnly,
                          IsOwnerOrReadOnly,)

    def perform_create(self, serializer):
        logger = logging.getLogger(__name__)
        serializer.save(owner=self.request.user)


class UserViewSet(viewsets.ReadOnlyModelViewSet):
    """
    This viewset automatically provides `list` and `detail` actions.
    """
    logger = logging.getLogger(__name__)
    queryset = User.objects.all()
    serializer_class = UserSerializer


def GetMedia(request, path):
    logger = logging.getLogger(__name__)
    logger.info(path)
    fpath = os.path.abspath(os.path.join(settings.MEDIA_ROOT,path))
    logger.info(fpath)
    with open(fpath,'rb') as f:
        logger.info('file paths:')
        name = f.name.split('/')
        name.reverse()
        fname = os.path.join(name[1], name[0])
        logger.info(fname)
        fpathnew = os.path.join('/home/shikha.desai/DownloadTest/media/',fname)
        logger.info(fpathnew)

        with open(fpathnew,'wb') as new:
            new.seek(0)
            new.truncate()
            copyfile(fpath, fpathnew)

    return HttpResponseRedirect('http://127.0.0.1:8000/')

# def GetMedia(request, path):
#     logger = logging.getLogger(__name__)
#     logger.info(path)
#     fpath = os.path.abspath(os.path.join(settings.MEDIA_ROOT,path))
#     logger.info(fpath)
#     with open(fpath,'rb') as f:
#         logger.info('file paths:')
#         name = f.name.split('/')
#         name.reverse()
#         fname = os.path.join(name[1], name[0])
#         logger.info(fname)
#         fpathnew = os.path.join('/home/shikha.desai/DownloadTest/media/',fname)
#         logger.info(fpathnew)
#         logger.info("Size of old file")
#         size = os.path.getsize(fpath)
#         logger.info(size)
#         with open(fpathnew,'ab') as new:
#             new.seek(0)
#             new.truncate()
#             i = 0
#             chunk_size = 1024
#             while True:
#                 chunk = f.read(chunk_size)
#                 if f.tell() == size:
#                     break
#                 new.write(bytes(chunk))
#                 i += 1
#                 s = "Writing chunk {}".format(i)
#                 logger.info(s)
#             logger.info("Size of new file")
#             logger.info(os.path.getsize(fpathnew))
#
#     return HttpResponseRedirect('http://127.0.0.1:8000/')